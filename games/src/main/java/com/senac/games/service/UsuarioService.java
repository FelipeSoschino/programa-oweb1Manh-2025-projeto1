package com.senac.games.service;


import com.senac.games.dto.request.PremioDTOUpdateRequest;
import com.senac.games.dto.request.UsuarioDTORequest;
import com.senac.games.dto.request.UsuarioDTOUpdateRequest;
import com.senac.games.dto.response.PremioDTOUpdateResponse;
import com.senac.games.dto.response.UsuarioDTOResponse;
import com.senac.games.dto.response.UsuarioDTOUpdateResponse;
import com.senac.games.entity.Premio;
import com.senac.games.entity.Usuario;
import com.senac.games.entity.Usuario;
import com.senac.games.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public Usuario listarUsuarioPorId(Integer usuarioId){
        return this.usuarioRepository.findById(usuarioId).orElse(null);

    }
    public UsuarioDTOResponse criarUsuario(UsuarioDTORequest usuarioDTORequest) {

        Usuario usuario = modelMapper.map(usuarioDTORequest, Usuario.class);

        Usuario usuarioSave = this.usuarioRepository.save(usuario);
        UsuarioDTOResponse usuarioDTOResponse = modelMapper.map(usuarioSave, UsuarioDTOResponse.class);
        return usuarioDTOResponse;}

    public UsuarioDTOResponse atualizarUsuario(Integer usuarioId, UsuarioDTORequest usuarioDTORequest){
        Usuario usuario = this.listarUsuarioPorId(usuarioId);
        if(usuario!=null){
            modelMapper.map(usuarioDTORequest,usuario);
            Usuario usuarioSave = this.usuarioRepository.save(usuario);
            UsuarioDTOResponse usuarioDTOResponse = modelMapper.map(usuarioSave,UsuarioDTOResponse.class);
            return usuarioDTOResponse;
        }
        else {return null;}
    }
    public UsuarioDTOUpdateResponse atualizarStatusUsuario(Integer usuarioId, UsuarioDTOUpdateRequest usuarioDTOUpdateRequest) {
        Usuario usuario = this.listarUsuarioPorId(usuarioId);
        if (usuario != null) {
            modelMapper.map(usuarioDTOUpdateRequest, usuario);
            Usuario usuarioSave = this.usuarioRepository.save(usuario);

            UsuarioDTOUpdateResponse usuarioDTOUpdateResponse = modelMapper.map(usuarioSave, UsuarioDTOUpdateResponse.class);
            return usuarioDTOUpdateResponse;
        } else
            return null;
    }

    public void apagarUsuario(Integer usuarioId){
        this.usuarioRepository.apagarUsuario(usuarioId);
    }
}
